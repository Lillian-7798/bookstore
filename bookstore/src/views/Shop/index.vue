<template>
  <div>
    <Header />
    <Product />
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Head";
import Footer from  "@/components/Foot";
import Product from "@/views/Shop/product";
export default {
  // name: 'Home',
  components:{
    Header,
    Product,
    Footer,
  },
};
</script>

<style scoped>

</style>