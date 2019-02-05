<template>
    <div>
        <div id="menu">
            <router-button to="/admin/image" text="Image"></router-button>
            <router-button to="/admin" text="Asset Bundle"></router-button>
            <router-button to="/admin/resource" text="Resource"></router-button>
            <router-button to="/admin/recipe" text="Recipe"></router-button>
            <router-button to="/admin/supplier" text="Supplier"></router-button>
        </div>
    </div>
</template>

<script>
    import RouterButton from '../RouterButton'
    export default {
        name: "AdminSideMenu",
        components: {RouterButton}
    }
</script>

<style scoped>
    #menu{
        text-decoration:none;
        background: #c7d1ff;
        width: 230px;
        font-size: 18px;
        margin-left: 16%;
    }
    button{
        background-color: rgba(1, 0, 255, 0.4);
        border-radius: 5px;
        border-style: none;
        font-family: fantasy;
        font-size: 22px;
        color: #03007b;
        margin: 15px;
        width: 200px;
        height: 35px;
    }
    button:hover{
        background-color: #0004ff;
    }
</style>