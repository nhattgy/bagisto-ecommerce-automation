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

        stage('Run Automation Test (Local Maven)') {
            steps {
                bat 'mvn clean test'
            }
        }
    }


}
