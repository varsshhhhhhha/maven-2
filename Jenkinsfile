pipeline {
    agent any
    tools {
        maven 'sonarmaven' // Ensure this matches the Maven configuration in Jenkins
    }
    environment {
        SONAR_TOKEN = credentials('maven-token') // Replace with your credentials ID for the SonarQube token
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17'
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build and Test') {
            steps {
                bat 'mvn clean verify'
            }
        }
        stage('Clean target folder') {
            steps {
                echo 'Cleaning target directory...'
                bat '''
                mvn clean
                '''
            }
        }

        stage('Test') {
            steps {
                echo 'Testing the project...'
                bat '''
                mvn test
                '''
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the compiled code...'
                bat '''
                mvn package
                '''
            }
        }
        stage('SonarQube Analysis') {
    steps {
        withSonarQubeEnv('sonarqube') { // Ensure this matches your SonarQube configuration
            bat """
                mvn sonar:sonar \
                -Dsonar.projectKey=newmaven \
                -Dsonar.projectName='newmaven' \
                -Dsonar.host.url=http://localhost:9000 \
                -Dsonar.token=sqa_0399ad10c9c66730ae457056710645420534c66b \
                -Dsonar.tests=src/test/java ^
                -Dsonar.java.binaries=target/classes ^
            """
        }
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }

}