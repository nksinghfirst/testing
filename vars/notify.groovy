def call(Map params = [:]) {
    // Extract folder name from JOB_NAME
    def folderName = env.JOB_NAME.split('/')[0]
    
    emailext(
        attachLog: params.attachLog ?: true,
        body: params.body ?: """Build status: ${currentBuild.result}.
Please check the logs for more details.
Job: ${JOB_NAME}
Folder: ${folderName}
Build Number: ${BUILD_NUMBER}
Build URL: ${BUILD_URL}
        """,
        subject: params.subject ?: "Build ${currentBuild.result} for ${folderName}",
        to: params.to ?: 'nks@gmail.com',
        from: params.from ?: 'alert@stacknize.com'
    )
}
