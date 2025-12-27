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

        stage('Prepare Allure History (optional)') {
            steps {
                bat '''
                if exist allure-report\\history (
                    if not exist allure-results\\history mkdir allure-results\\history
                    xcopy /E /I /Y allure-report\\history allure-results\\history
                ) else (
                    echo No previous allure history found in workspace
                )
                '''
            }
        }

        stage('Run Automation Test (Local Maven)') {
            steps {
                bat '''
                if not exist allure-results mkdir allure-results
                mvn clean test
                '''
            }
        }
    }

    post {
        always {
            // Publish Allure from ROOT: allure-results
            allure([
                includeProperties: false,
                results: [[path: 'allure-results']]
            ])

            // (Optional) lưu file results lại để debug
            archiveArtifacts artifacts: 'allure-results/**', allowEmptyArchive: true
        }
    }
}
