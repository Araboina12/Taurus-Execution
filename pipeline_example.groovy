node {
   stage('Build') {
      // Run the Taurus build
   }
   stage('Performance Tests') {
    parallel(
        BlazeMeterTest: {
            dir ('C:\Users\kumar12\Taurus Resources') {
               sh 'bzt taurus_jmeter_script1.yml -report'
            }
        },
        Analysis: {
            sleep 60
        })
   }

   stage('Deploy') {
   }
}
