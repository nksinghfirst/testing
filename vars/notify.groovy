def call() {
    emailext attachLog: true, body: '', subject: 'Build for this has started', to: 'nksinghfirst@gmail.com'
}
