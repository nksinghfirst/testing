def call() {
    emailext attachLog: true, body: 'test', subject: 'Build for this has started', to: 'nksinghfirst@gmail.com'
}
