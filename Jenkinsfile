pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                git 'https://github.com/ADirin/demo2026.git'
            }
        }

        stage('Build'){
            steps {
                bat 'mav clean install'
            }
        }
        stage('Test'){
            steps{
                bat 'mvn test'
            }
        }

        stage('code coverage'){
            steps{
                jacoco()
            }
        }
    }

}