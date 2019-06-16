
node {
    stage('Clone sources') {
        git branch: 'develop',
        credentialsId: 'git_credential',
        url: 'https://github.com/DCMFC/employee-manager.git'
    }
    
    stage('Build')
    {
        sh 'cd employee-manager/magazine_luiza/'
        sh 'virtualenv env && source env/bin/activate && pip3 install --upgrade -r requirements.txt'
    }
   
}
