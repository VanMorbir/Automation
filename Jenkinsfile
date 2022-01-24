pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
               bat ' ./mvnw compile -f ParaBankTesting'
            }
        }
        try {
            stage('Test') {
                steps {
                    bat './mvnw test -f ParaBankTesting'
                }
            }
        catch (Exception e) {
            echo "Some tests failed, moving on"
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