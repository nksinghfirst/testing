def call(Map params = [:]) {
    // Extract the folder name from JOB_NAME
    def folderName = env.JOB_NAME.split('/')[0]

    // Default email parameters
    def defaultParams = [
        attachLog: true,
        body: """Build status: ${currentBuild.result}.
Please check the logs for more details.
Job: ${env.JOB_NAME}
Folder: ${folderName}
Build Number: ${env.BUILD_NUMBER}
Build URL: ${env.BUILD_URL}
        """,
        subject: "Build ${currentBuild.result} for ${folderName}",
        to: 'nksinghfirst@gmail.com'
    ]

    // Merge provided params with defaults
    def emailParams = defaultParams + params

    // Send the email
    emailext(
        attachLog: emailParams.attachLog,
        body: emailParams.body,
        subject: emailParams.subject,
        to: emailParams.to
    )
}

