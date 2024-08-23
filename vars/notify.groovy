def call(Map params = [:]) {
    emailext(
        to: 'nksinghfirst@gmail.com',
        subject: params.subject ?: "Build ${currentBuild.result} for ${env.FOLDER_NAME}",
        body: params.body ?: """
            Build status: ${currentBuild.result}. Please check the logs for more details.
Job: ${JOB_NAME}
Build Number: ${BUILD_NUMBER}
Build URL: ${BUILD_URL}
""",
        attachLog: true
    )
}
