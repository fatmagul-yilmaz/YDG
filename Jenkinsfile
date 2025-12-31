pipeline {
    agent any

    environment {
        MAVEN_OPTS = "-Xmx1024m"
    }

    stages {

        /* =========================
           CHECKOUT (NO CHANGELOG)
        ========================== */
        stage('Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/fatmagul-yilmaz/YDG.git'
                    ]],
                    changelog: false,
                    poll: false
                ])
            }
        }

        /* =========================
           BUILD + UNIT + INTEGRATION
        ========================== */
        stage('Build + Unit + Integration Tests') {
            steps {
                bat '''
                cd Alisveris-Sitesi---backend-main
                mvn clean verify
                '''
            }
        }

        /* =========================
           START BACKEND
        ========================== */
        stage('Start Backend') {
            steps {
                bat '''
                cd Alisveris-Sitesi---backend-main
                start /B mvn spring-boot:run
                ping 127.0.0.1 -n 20 > nul
                '''
            }
        }

        /* =========================
           SELENIUM UI TESTS
        ========================== */
        stage('Selenium UI Tests') {
            steps {
                bat '''
                cd Alisveris-Sitesi---backend-main
                mvn test -Pselenium
                '''
            }
        }
    }

    post {
        success {
            echo 'PIPELINE BAŞARILI ✅ FULL GREEN'
        }
        failure {
            echo 'PIPELINE HATALI ❌'
        }
        always {
            echo 'Pipeline tamamlandı'
        }
    }
}
