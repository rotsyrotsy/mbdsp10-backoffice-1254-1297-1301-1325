import com.itu.mbds.CustomPasswordEncoder
import com.itu.mbds.CustomUserDetailsService
import com.itu.mbds.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    //userDetailsService(CustomUserDetailsService)
    //passwordEncoder(CustomPasswordEncoder)
}
