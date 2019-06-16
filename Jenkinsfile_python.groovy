
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
        sh 'python3 manage.py test'
    }
   
}
