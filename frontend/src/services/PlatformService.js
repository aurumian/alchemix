export default {
    check(){
        let Class;

        //Determine device type
        if (window.outerWidth < 776){
            //mobile
            Class = 'mobile';
        }
        else if (window.outerWidth < 1056){
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