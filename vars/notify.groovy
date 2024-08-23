def call(Map params = [:]) {
    emailext(
        to: params.to ?: 'nksinghfirst@gmail.com',
        subject: params.subject ?: "Build ${currentBuild.result} for I-Heal",
        body: params.body ?: """
            Build status: ${currentBuild.result}. Please check the logs for more details.
        Job: ${JOB_NAME}
        Build Number: ${BUILD_NUMBER}
        Build URL: ${BUILD_URL}
        """,
        attachLog: params.attachLog ?: true
    )
}
