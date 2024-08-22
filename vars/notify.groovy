def call() {
    emailext (
        attachLog: true,
        body: """Build status: ${currentBuild.result}.
Please check the logs for more details.
Job: ${JOB_NAME}
Build Number: ${BUILD_NUMBER}
Build URL: ${BUILD_URL}
        """,
        subject: "Build ${currentBuild.result} for ${env.JOB_NAME}",
        to: 'nksinghfirst@gmail.com'
    )
}
