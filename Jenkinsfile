pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
               echo 'This is a minimal pipeline.'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn tests'
            }
        }
    }
}