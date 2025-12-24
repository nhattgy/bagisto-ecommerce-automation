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

        stage('Start Selenium Grid (10 Chrome Nodes)') {
            steps {
                bat '''
                docker compose down
                docker compose up -d --scale chrome=10
                '''
            }
        }

        stage('Run Automation Test (Local Maven)') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            bat 'docker compose down'

            allure([
                includeProperties: false,
                results: [[path: 'allure-results']]
            ])
        }
    }
}
