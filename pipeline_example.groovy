node {
   stage('Build') {
      // Run the Taurus build
   }
   stage('Performance Tests') {
    parallel(
        BlazeMeterTest: {
            dir ('Taurus-Repo') {
                sh 'bzt <file_name>.yml -report'
            }
        },
        Analysis: {
            sleep 60
        })
   }

   stage(‘Deploy’) {
   }
}