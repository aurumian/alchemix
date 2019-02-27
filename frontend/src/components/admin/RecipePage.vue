<template>
    <div>
        <add-recipe></add-recipe>
        <recipes url="/admin/api/recipe/get" :display-id="true"></recipes>
    </div>
</template>

<script>
    import AddRecipe from "./AddRecipe";
    import Recipes from "../Recipes";
    export default {
        name: "RecipePage",
        components: {Recipes, AddRecipe}
    }
</script>

<style scoped>

</style>