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
                script {
                    try {
                        bat './mvnw test -f ParaBankTesting -Dtest=AlltestSuite'
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

                emailext subject: 'ParaBank Test Report',
                                    body: '${FILE,path="ParaBankTestingReport.html"}',
                                    to: 'vanmorbir@gmail.com',
                                    mimeType: 'text/html'
            }
        }
    }
}