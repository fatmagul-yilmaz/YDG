pipeline {
    agent any

    parameters {
        booleanParam(
            name: 'RUN_SELENIUM',
            defaultValue: false,
            description: 'Selenium UI testlerini çalıştır'
        )
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build + Unit + Integration Tests') {
            steps {
                echo 'Build, Unit ve Integration testleri çalıştırılıyor...'
                bat 'mvnw.cmd clean verify -Dskip.selenium=true'
            }
        }

        stage('Selenium UI Tests') {
            when {
                expression { params.RUN_SELENIUM == true }
            }
            steps {
                echo 'Selenium testleri çalıştırılıyor...'
                bat 'mvnw.cmd test -Dselenium=true'
            }
        }
    }

    post {
        success {
            echo 'Pipeline BAŞARILI ✅'
        }
        failure {
            echo 'Pipeline BAŞARISIZ ❌'
        }
    }
}
