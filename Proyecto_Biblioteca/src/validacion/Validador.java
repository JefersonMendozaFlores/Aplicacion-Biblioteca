package validacion;

public class Validador {
	public static final String DNI = "[0-9]{8}";
	public static final String CORREO_GMAIL = "[a-zA-Z]+(@gmail.com)";
	public static final String NOMBRE = "[a-zA-ZÑñáéíóúÁÉÍÓÚ\\s]{3,30}";
	public static final String APELLIDO = "[a-zA-ZÑñÁÉÍÓÚáéíóú\\s]{3,30}";
	public static final String FECHANAC = "[0-9]{4}+[-][0-9]{2}+[-][0-9]{2}";
}
