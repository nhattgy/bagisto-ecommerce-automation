pipeline {
    agent any

    stages {
        stage('Automation Bagisto full') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/nhattgy/bagisto-ecommerce-automation.git',
                    credentialsId: 'Github_Token'
            }
        }

        stage('Prepare Allure History') {
            steps {
                script {
                    if (fileExists('allure-report\\history')) {
                        bat 'xcopy /E /I /Y allure-report\\history allure-results\\history'
                    } else {
                        echo 'No previous Allure history found'
                    }
                }
            }
        }

        stage('Run Test') {
            steps {
                bat 'mvn clean test'
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
