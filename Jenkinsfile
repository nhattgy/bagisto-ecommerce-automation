pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/nhattgy/bagisto-ecommerce-automation.git',
                    credentialsId: 'Github_Token'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t bagisto-automation .'
            }
        }

        stage('Run Automation Test (Docker)') {
            steps {
                bat '''
                docker run --rm ^
                  -v "%cd%":/app ^
                  -w /app ^
                  bagisto-automation ^
                  mvn clean test
                '''
            }
        }
    }

    post {
        always {
            allure([
                includeProperties: false,
                results: [[path: 'allure-results']]
            ])
        }
    }
}
