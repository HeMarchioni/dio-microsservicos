package digitalinnovation.one.experts.shoppingcart.controller;

import digitalinnovation.one.experts.shoppingcart.model.Cart;
import digitalinnovation.one.experts.shoppingcart.model.Item;
import digitalinnovation.one.experts.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if (savedCart.equals(Optional.empty())) {
            cart = new Cart(id);
        }
        else {
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable("id") Integer id) {
        return cartRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void clear(@PathVariable("id") Integer id) {
        cartRepository.deleteById(id);
    }

}
