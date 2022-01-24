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
            }
        }
    }
}