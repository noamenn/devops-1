String branchName = "taha-dev"
String gitCredentials = "GITHUB"
String repoUrl ="https://github.com/ons-11/devops"
String dockerRepoUrl = "localhost:8083"
String dockerImageName = "devops"
String dockerImageTag = "${dockerRepoUrl}/${dockerImageName}:${env.BUILD_NUMBER}"
node {
    echo 'Make build directory'
    sh 'mkdir -p build'

    stage('Git - Clone'){
        echo 'Cloning files from (branch: "' + branchName +'" )'
        dir('build') {
            sh 'rm -rf ./*'
            git branch : branchName, credentialsId: gitCredentials, url: repoUrl 
        }
    }

    stage('Maven - Build'){
        dir('build'){
        sh "/usr/local/apache-maven/bin/mvn clean package"
        }
    }

    def image = stage('Docker - Build image'){
        docker.build(dockerImageTag , '.')
    }

}