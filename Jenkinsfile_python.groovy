
node {
    stage('Clone sources') {
        git url: 'https://github.com/DCMFC/employee-manager.git'
    }
}
