package thiago.formulariocadastroaluno;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 4 label
 * 4 txt field
 * 3 cmb
 * 3 btn
 */
public class FormularioCadastroAluno extends JFrame {
// Declaração dos componentes do formulário
    private JLabel labelNome, labelSobrenome, labelNascimento, 
            labelEscolaridade, labelCurso, labelTurma, labelTelefone, 
            labelRua, labelNumero, labelCidade, labelEstado, labelDeficiencia, labelSexo;
    
    private JTextField campoNome, campoSobrenome, campoNascimento, campoTelefone, 
            campoRua, campoNumero, campoCidade;
    
    private JComboBox<String> comboEscolaridade, comboCurso, comboTurma, 
            comboEstado, comboDeficiencia, comboSexo;
    
    private JButton botaoSalvar, botaoDescartar, botaoVerificarDisp;

    public FormularioCadastroAluno() {
        // Configurações da janela
        setTitle("Cadastro de Aluno");
        setSize(620, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a ação ao clicar no X
        setLayout(new GridLayout(16, 2, 10, 7));

        // Inicialização dos componentes
        labelNome = new JLabel("Nome:");
        labelSobrenome = new JLabel("Sobrenome:");
        labelDeficiencia = new JLabel("Possui deficiencia:");
        labelSexo = new JLabel("Sexo:");
        labelTelefone = new JLabel("Telefone:");
        labelNascimento = new JLabel("Nascimento:");
        labelEscolaridade = new JLabel("Escolaridade:");
        labelCurso = new JLabel("Curso:");
        labelTurma = new JLabel("Turma:");
        labelRua = new JLabel("Rua:");
        labelNumero = new JLabel("Numero:");
        labelCidade = new JLabel("Cidade:");
        labelEstado = new JLabel("Estado:");
        
        campoNome = new JTextField();
        campoSobrenome = new JTextField();
        campoTelefone = new JTextField();
        campoNascimento = new JTextField();
        campoRua = new JTextField();
        campoNumero = new JTextField();
        campoCidade = new JTextField();

        String[] sexo = {"MASCULINO", "FEMININO"};
        comboSexo = new JComboBox<>(sexo);
        
        String[] deficiencia = {"NAO", "SIM"};
        comboDeficiencia = new JComboBox<>(deficiencia);
        
        String[] escolaridades = {"Ensino Médio", "Graduação", "Pós-graduação"};
        comboEscolaridade = new JComboBox<>(escolaridades);

        String[] cursos = {"Ciência da Computação", "Engenharia", "Matemática", "Física"};
        comboCurso = new JComboBox<>(cursos);

        String[] turmas = {"A", "B", "C", "D"};
        comboTurma = new JComboBox<>(turmas);
        
        String[] estados = {"ES", "RJ", "SP", "BH", "BA"};
        comboEstado = new JComboBox<>(estados);
        
        botaoSalvar = new JButton("Salvar");
        botaoDescartar = new JButton("Descartar");
        botaoVerificarDisp = new JButton("Verificar Vagas");
        
        // Adicionando os componentes na janela
        add(labelNome);
        add(campoNome);
        add(labelSobrenome);
        add(campoSobrenome);
        add(labelSexo);
        add(comboSexo);
        add(labelDeficiencia);
        add(comboDeficiencia);
        add(labelTelefone);
        add(campoTelefone);
        add(labelNascimento);
        add(campoNascimento);
        add(labelRua);
        add(campoRua);
        add(labelNumero);
        add(campoNumero);
        add(labelCidade);
        add(campoCidade);
        add(labelEstado);
        add(comboEstado);
        add(labelEscolaridade);
        add(comboEscolaridade);
        add(labelCurso);
        add(comboCurso);        
        add(labelTurma);
        add(comboTurma);
        add(new JLabel());
        add(botaoVerificarDisp);
        //add(new JLabel()); // Espaço vazio para alinhamento
        add(botaoSalvar);
        add(botaoDescartar);

        // Exibe a janela
        setVisible(true);
    }
    public static void main(String[] args) {
        new FormularioCadastroAluno();
    }
}
