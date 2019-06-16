
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
        new File(System.getProperty("user.dir")).name
        sh 'cd magazine_luiza/'
        sh 'pip3 install --upgrade -r requirements.txt'
    }
   
}
