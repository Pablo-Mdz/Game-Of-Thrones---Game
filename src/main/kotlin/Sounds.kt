import java.io.File
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.FloatControl


open class Sounds {

    var intro: String = "sounds/intro.wav"
    var menu: String = "sounds/menu-sound.wav"
    val dragon : String = "sounds/dragon-1.wav"
    val arrows : String = "sounds/arrows.wav"
    val round : String = "sounds/round2.wav"
    val live : String = "sounds/live.wav"
    val army : String = "sounds/army.wav"
    val ahu : String = "sounds/ahu.wav"
    val ahuWoman : String = "sounds/ahuWoman.wav"
    val lose : String = "sounds/lose.wav"
    val wolf : String = "sounds/wolf.wav"
    val ice : String = "sounds/ice.wav"
    val winner : String = "sounds/winner.wav"

    /**
     * Plays a specified sound file.
     *
     * This function loads and plays the audio file specified by the `audioPath`.
     * It uses Java Sound library to load and play the file.
     *
     * @param audioPath The path of the sound file to be played.
     */
  open  fun playSound(audioPath: String) {
        val audio: File = File(audioPath)

        val audioInput: AudioInputStream = AudioSystem.getAudioInputStream(audio)

        val clip: Clip = AudioSystem.getClip()

        clip.open(audioInput)

        clip.start()
        // Volume Control:
        // FloatControl steuert Audios (zB Lautstärke)
        // MASTER_GAIN ist eine spezielle Art von FloatControl, die die Lautstärke eines Audio-Clips regelt
//        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
//            val volume: FloatControl = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl
//            // weiterer Code zur Steuerung der Lautstärke
//            // 0.99 = fast das maximum, spektrum geht von 0 (kein Sound) bis 1 (lautester Sound)
//            volume.value = volume.minimum + (0.99f * (volume.maximum - volume.minimum))
//        } else {
//            println("Master Gain control not supported.")
//        }
    }
}