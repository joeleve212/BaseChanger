class App {
    constructor(){
        this.load()
        const form = document.querySelector('form')
        form.addEventListener('submit', (ev) => {
            ev.preventDefault()
            this.handleSubmit(ev)
        })
    }
    load(){
        //
    }

    handleSubmit(ev){
        //take input data and pass to back end java program
    }
}