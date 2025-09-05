pipeline {
    agent any

    tools {
        maven 'Maven3'   // Jenkins configured Maven
        jdk 'Java17'     // Jenkins configured JDK
    }

    environment {
        DOCKER_CREDENTIALS = credentials('dockerhub-username-password') // Dockerhub credentials
        SONARQUBE = 'SonarQubeServer'                  // Jenkins SonarQube server name
        EMAIL_RECIPIENTS = 'bunmiolowoyeye20@gmail.com' // Email recipients
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'dev', url: 'https://github.com/Bummieboaxyl/NumberGuessGame.git'
            }
        }

        stage('Code Quality') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {  // matches SONARQUBE environment
                    sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=NumberGuessGame'
                }
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests=false'
            }
        }

        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package WAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true
            }
        }

        stage('Docker Build & Push') {
            steps {
                sh '''
                    echo $DOCKER_CREDENTIALS_PSW | docker login -u $DOCKER_CREDENTIALS_USR --password-stdin
                    docker build -t $DOCKER_CREDENTIALS_USR/number-guess-game:latest .
                    docker push $DOCKER_CREDENTIALS_USR/number-guess-game:latest
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    docker stop number-guess-game || true
                    docker rm number-guess-game || true
                    docker run -d --name number-guess-game -p 8080:8080 $DOCKER_CREDENTIALS_USR/number-guess-game:latest
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Build, Test, SonarQube analysis, and Deploy succeeded!'
            mail bcc: '', body: "The Jenkins build for NumberGuessGame succeeded!\n\nCheck: ${env.BUILD_URL}", 
                 cc: '', from: '', replyTo: '', subject: "Jenkins Build Success: NumberGuessGame", 
                 to: "${EMAIL_RECIPIENTS}"
        }
        failure {
            echo '❌ Build failed. Check Jenkins logs!'
            mail bcc: '', body: "The Jenkins build for NumberGuessGame failed!\n\nCheck: ${env.BUILD_URL}", 
                 cc: '', from: '', replyTo: '', subject: "Jenkins Build Failed: NumberGuessGame", 
                 to: "${EMAIL_RECIPIENTS}"
        }
    }
}
