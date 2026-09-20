pipeline {
    agent any
    tools {
        maven 'Maven3'
    }

    stages {
        stage('checkout') {
            steps {
                git 'https://github.com/ADirin/demo2026.git'
            }
        }

        stage('Build'){
            steps {
                bat 'mvn clean install'
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