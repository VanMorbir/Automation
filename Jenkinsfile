pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
               bat ' ./mvnw compile -f ParaBankTesting'
            }
        }
        stage('Test') {
            steps {
                //bat 'cd ParaBankTesting'
                script {
                    try {
                        bat './mvnw test -f ParaBankTesting'
                    }
                    catch (Exception e) {
                        echo "Faild tests, publishing report anyway"
                    }
                }
            }
        }
        stage('Report') {
            steps {
                publishHTML([
                                    allowMissing: false,
                                    alwaysLinkToLastBuild: false,
                                    keepAll: false,
                                    reportDir: '.',
                                    reportFiles: 'ParaBankTestingReport.html',
                                    reportName: 'ExtentReport',
                                    reportTitles: ''])
            }
        }
    }
}