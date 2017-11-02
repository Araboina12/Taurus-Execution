node {
   stage('Build') {
      // Run the Taurus build
   }
   stage('Performance Tests') {
    parallel(
        BlazeMeterTest: {
            dir ('/Desktop/Taurus Resources') {
                 bat 'Taurus.bat'
            }
        },
        Analysis: {
            sleep 60
        })
   }

   stage('Deploy') {
   }
}
