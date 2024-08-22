//def call() {
//    emailext attachLog: true, body: 'test', subject: 'Build for this has started', to: 'nksinghfirst@gmail.com'
//}

def call(Map params = [:]) {
    emailext(
        from: params.from ?: 'alert@stacknize.com',
        to: params.to ?: 'nksinghfirst@gmail.com',
        subject: params.subject ?: "Build ${currentBuild.result} for I-Heal",
        body: params.body ?: """
            Build status: ${currentBuild.result}.
            Please check the logs for more details.
            Job: ${JOB_NAME}
            Build Number: ${BUILD_NUMBER}
            Build URL: ${BUILD_URL}
        """,
        attachLog: params.attachLog ?: true
    )
}
