pipeline {
    agent any

    stages {
        stage('E2E Test bagisto ecommerce') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/nhattgy/bagisto-ecommerce-automation.git',
                    credentialsId: 'Github_Token'
            }
        }

        stage('Run Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Allure Report') {
            steps {
                allure([
                    includeProperties: false,
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }
}
