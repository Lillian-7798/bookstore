<template>
  <div>
    <Header />
    <Cart />
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Head";
import Footer from  "@/components/Foot";
import Cart from  "./cart"
export default {
  components:{
    Header,
    Cart,
    Footer,
  },
};
</script>

<style scoped>

</style>