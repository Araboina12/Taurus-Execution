node {
   stage('Build') {
      // Run the Taurus build
   }
   stage('Performance Tests') {
    parallel(
        BlazeMeterTest: {
            dir ('Taurus Resources') {
                'bzt taurus_jmeter_script1.yml -report'
            }
        },
        Analysis: {
            sleep 60
        })
   }

   stage(‘Deploy’) {
   }
}
