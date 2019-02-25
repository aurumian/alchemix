export default {
    check(){
        let Class;

        //Determine device type
        if (window.innerWidth < 776){
            //mobile
            Class = 'mobile';
        }
        else if (window.innerWidth < 1056){
            //tablet
            Class = 'desktop';
        }
        else {
            //desktop
            Class = 'desktop';
        }


        let divs = document.getElementsByTagName('div');

        for (let i = 0; i < divs.length; i++){
            divs[i].classList.remove('desktop', 'mobile');
            divs[i].classList.add(Class);
        }

        console.log("Changing to class: " + Class);

    }
}