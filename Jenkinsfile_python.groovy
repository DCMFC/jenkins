
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
        sh 'virtualenv env && . env/bin/activate'
        sh 'python3 manage.py test'
        sh 'nosetests --with-coverage --cover-xml --cover-package=magazine_luiza --with-xunit test'
    }
    
    stage('SonarQube') {
        def scannerHome = tool 'SonarQubeScanner';
        withSonarQubeEnv('sonarqube') {
            sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=magazine_luiza -Dproject.settings=../sonar-project.properties"
        }
    }
   
}
