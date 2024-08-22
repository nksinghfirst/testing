//def call() {
//    emailext attachLog: true, body: 'test', subject: 'Build for this has started', to: 'nksinghfirst@gmail.com'
//}



def call(Map params = [:]) {
    // Hardcode the default subject and body
    String defaultSubject = "Build ${currentBuild.result} for I-Heal"
    String defaultBody = """
        Build status: ${currentBuild.result}.
        Please check the logs for more details.
        Job: ${JOB_NAME}
        Build Number: ${BUILD_NUMBER}
        Build URL: ${BUILD_URL}
    """
    
    // Use the default values if none are provided
    emailext(
        from: params.get('from', 'alert@stacknize.com'),
        to: params.get('to', 'nksinghfirst@gmail.com'),
        subject: params.get('subject', defaultSubject),
        body: params.get('body', defaultBody),
        attachLog: params.get('attachLog', true)
    )
}
