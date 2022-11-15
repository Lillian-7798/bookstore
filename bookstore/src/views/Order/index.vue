<template>
  <div>
    <Header />
    <Order />
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Head";
import Footer from  "@/components/Foot";
import Order from "@/views/Order/order";
export default {
  components: {
    Header,
    Order,
    Footer
  }
}
</script>

<style scoped>

</style>