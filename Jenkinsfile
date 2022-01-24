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
                bat './mvnw test -f ParaBankTesting'
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