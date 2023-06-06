package ra.security.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ra.security.userprincipal.UserPrincipal;

import java.util.Date;

@Component
public class JwtProvider {
    // lớp logger giúp ta ghi log bắt các trường hợp ngoại lệ
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtSecret = "jwt.ra";
    // set thời gian sng cho token
    private int jwtExpiration = 86400;

    // hàm tiến hành mã hóa chuỗi user thành chuỗi token , được gọi tại api login trên controller
    public String generateJwtToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
    // hàm tiến hành kiểm tra tính hợp lệ của token đng đăng nhập

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        }catch (SignatureException e){
            logger.error("invalid Jwt signature -> Message : {}",e);
        }catch (MalformedJwtException e){
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }

        return false;
    }
    // Hàm lấy lại thông tin ngời dùng từ chính token tạo ra
    public String getUserNameFromJwtToken(String token){
        String userName =Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return userName;
    }



}
