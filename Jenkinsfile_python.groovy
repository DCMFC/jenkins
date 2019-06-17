
node {
    stage('Clone sources') {
        git branch: 'develop',
        credentialsId: 'git_credential',
        url: 'https://github.com/DCMFC/employee-manager.git'
    }
    
    stage('Build')
    {
        sh 'cd magazine_luiza/'
        sh 'virtualenv env && . env/bin/activate'
        sh 'pip3 install --upgrade -r magazine_luiza/requirements.txt'
    }
    
    stage('Test')
    {
        sh 'python3 magazine_luiza/manage.py test'
    }
    
    stage('SonarQube') {
        def scannerHome = tool 'SonarQubeScanner';
        withSonarQubeEnv('sonarqube') {
            sh "${scannerHome}/bin/sonar-scanner sonar.login=08739ca0fb17d55c0f41ef1b23bb0a03b1ffcb31"
        }
    }
   
}
